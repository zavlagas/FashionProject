/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SuperDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return (sessionFactory.getCurrentSession());
    }

}
