package com.pulsars.adventure.migration;

import org.flywaydb.core.Flyway;

public class Migrations {
    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://ec2-54-172-219-6.compute-1.amazonaws.com:5432/dc4pakcbf4ucrd";
        String user="faiqkdxyakowiw";
        String password="987226ac4510038d185dba3818d43dc729df8c59afb43a7db179f120a253c020";
        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.migrate();
    }
}
