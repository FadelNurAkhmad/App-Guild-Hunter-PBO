package sample.model;

import javax.swing.text.TableView;

public class GuildMaster extends User implements Management {
    //constructor
    public GuildMaster() { }
    public GuildMaster(String username, String password) { super(username, password); }


    @Override
    public void create(TableView tableView, Object object, MANAGE mode) { }

    @Override
    public void read(TableView tableView, MANAGE mode) { }

    @Override
    public void update(TableView tableView, Object object, MANAGE mode) { }

    @Override
    public void delete(TableView tableView, MANAGE mode) { }

    @Override
    public Object get(TableView tableView) { }
}
