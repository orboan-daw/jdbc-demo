module com.pluralcamp.daw.persistence {
    requires java.base;
    requires java.sql;
    requires mysql.connector.java;
    requires com.pluralcamp.daw.entitites;

    exports com.pluralcamp.daw.persistence.daos.contracts;
    exports com.pluralcamp.daw.persistence.daos.impl.jdbc; //!!
    exports com.pluralcamp.daw.persistence.exceptions;
}