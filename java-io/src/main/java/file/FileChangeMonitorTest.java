package file;

import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 开启监听
 */
public class FileChangeMonitorTest {

    public static void main(String[] args) throws Exception {
        int type = 1;
        FileAlterationObserver observer;
        if(type==1){// 使用过滤器过滤文件和文件夹
            IOFileFilter directories = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(),
                    HiddenFileFilter.VISIBLE);
            IOFileFilter files = FileFilterUtils.and(FileFilterUtils.falseFileFilter(),
                    FileFilterUtils.suffixFileFilter(".dat"));
            IOFileFilter filter = FileFilterUtils.or(directories,files);
            observer = new FileAlterationObserver(new File(""),filter);
        } else {// 不使用过滤器
            observer = new FileAlterationObserver(new File(""));
        }
        observer.addListener(new FileChangeMonitor());//

        // 设置监听频率
        long interval = TimeUnit.SECONDS.toMillis(1);
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval ,observer);
        monitor.start();
    }
}
