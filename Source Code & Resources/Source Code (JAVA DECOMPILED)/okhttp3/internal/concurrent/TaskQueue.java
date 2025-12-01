package okhttp3.internal.concurrent;

import androidx.appcompat.app.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import m0.k;
import okhttp3.internal._UtilJvmKt;
import y0.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(g.k(new StringBuilder(), _UtilJvmKt.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public TaskQueue(TaskRunner taskRunner, String name) {
        j.e(taskRunner, "taskRunner");
        j.e(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j, boolean z2, a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        taskQueue.execute(str, j, (i2 & 4) != 0 ? true : z2, aVar);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(task, j);
    }

    public final void cancelAll() {
        TaskRunner taskRunner = this.taskRunner;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(taskRunner)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + taskRunner);
        }
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            j.b(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z2 = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                Task task2 = this.futureTasks.get(size);
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void execute(String name, long j, boolean z2, final a block) {
        j.e(name, "name");
        j.e(block, "block");
        schedule(new Task(name, z2) { // from class: okhttp3.internal.concurrent.TaskQueue.execute.1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                block.invoke();
                return -1L;
            }
        }, j);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> listW0;
        synchronized (this.taskRunner) {
            listW0 = k.w0(this.futureTasks);
        }
        return listW0;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(Task task, long j) {
        j.e(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
            } else if (task.getCancelable()) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Logger logger$okhttp2 = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp2.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp2, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j, boolean z2) {
        String str;
        j.e(task, "task");
        task.initQueue$okhttp(this);
        long jNanoTime = this.taskRunner.getBackend().nanoTime();
        long j2 = jNanoTime + j;
        int iIndexOf = this.futureTasks.indexOf(task);
        if (iIndexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j2) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(iIndexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j2);
        Logger logger$okhttp2 = this.taskRunner.getLogger$okhttp();
        if (logger$okhttp2.isLoggable(Level.FINE)) {
            if (z2) {
                str = "run again after " + TaskLoggerKt.formatDuration(j2 - jNanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j2 - jNanoTime);
            }
            TaskLoggerKt.log(logger$okhttp2, task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime$okhttp() - jNanoTime > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.futureTasks.size();
        }
        this.futureTasks.add(size, task);
        return size == 0;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z2) {
        this.cancelActiveTask = z2;
    }

    public final void setShutdown$okhttp(boolean z2) {
        this.shutdown = z2;
    }

    public final void shutdown() {
        TaskRunner taskRunner = this.taskRunner;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(taskRunner)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + taskRunner);
        }
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j, a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(str, j, aVar);
    }

    public final void schedule(String name, long j, final a block) {
        j.e(name, "name");
        j.e(block, "block");
        schedule(new Task(name) { // from class: okhttp3.internal.concurrent.TaskQueue.schedule.2
            {
                int i2 = 2;
                e eVar = null;
                boolean z2 = false;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return ((Number) block.invoke()).longValue();
            }
        }, j);
    }
}
