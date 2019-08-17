package file;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

/**
 * 演示使用java监听文件和文件夹的变化
 * 导入common－io的jar包
 */
public class FileChangeMonitor extends FileAlterationListenerAdaptor {

    /**
     * 文件夹创建监听事件
     * @param directory
     */
    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
    }

    /**
     * 文件夹修改监听事件
     * @param directory
     */
    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
    }

    /**
     * 文件夹删除监听事件
     * @param directory
     */
    @Override
    public void onDirectoryDelete(File directory) {
        super.onDirectoryDelete(directory);
    }

    /**
     * 文件创建监听事件
     * @param file
     */
    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
    }

    /**
     * 文件修改监听事件
     * @param file
     */
    @Override
    public void onFileChange(File file) {
        super.onFileChange(file);
    }

    /**
     * 文件删除监听事件
     * @param file
     */
    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);
    }
}
