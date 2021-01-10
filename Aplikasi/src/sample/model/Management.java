package sample.model;

import javafx.scene.control.TableView;

public interface Management <T> {
    public enum MANAGE {JOB, QUEST, MEMBER, HERB, GOODS, MONSTER}

    void create(TableView<T> tableView, T object, MANAGE mode);

    void read(TableView<T> tableView, MANAGE mode);

    void update(TableView<T> tableView, T object, MANAGE mode);

    void delate(TableView<T> tableView, MANAGE mode);

    T get(TableView<T> tableView);
}
