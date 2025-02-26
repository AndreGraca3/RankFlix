package pt.graca.api.repo.file;

import com.google.gson.Gson;
import pt.graca.api.repo.IRepository;
import pt.graca.api.repo.transaction.ITransaction;

import java.io.IOException;

public class FileTransaction implements ITransaction {

    private final FileRepository repository;

    public FileTransaction(Gson gson, String folderName, String listName) {
        try {
            repository = new FileRepository(gson, folderName, listName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IRepository getRepository() {
        return repository;
    }

    @Override
    public void begin() {
        // Nothing to do here
    }

    @Override
    public void commit() {
        repository.saveData();
    }

    @Override
    public void rollback() {
        // Nothing to do here
    }

    @Override
    public void close() {
        // Nothing to do here
    }
}
