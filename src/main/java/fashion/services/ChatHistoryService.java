/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public interface ChatHistoryService {

    public void save(Map<String, String> message);

    public List<Map<String, String>> get();
    
}
