package FileUtility;

public  class FileWrapper implements IFile {
    IFile file;

    @Override
    public void create() {
        file.create();
    }
}
