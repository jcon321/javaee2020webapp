/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webapplication;

import javax.annotation.sql.DataSourceDefinition;

/**
 *
 * @author jbuntu
 */
@DataSourceDefinition(
        name = "java:global/Datasource",
        className = "com.mysql.jdbc.jdbc2.optional.MysqlXADataSource",
        url = "jdbc:mysql://172.17.0.1:3306/openlib",
        user = "root",
        password = "root"
)
public class DatabaseConfig {

}
