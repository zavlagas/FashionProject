/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public class StorageServiceImpl implements StorageService{

    @Override
    public void init() {
        
    }

    @Override
    public void store(MultipartFile file) {
      
    }

    @Override
    public Stream<Path> loadAll() {
        return  null;
    }

    @Override
    public Path load(String filename) {
         return  null;
    }

    @Override
    public Resource loadAsResource(String filename) {
      return  null;
    }

    @Override
    public void deleteAll() {
    
    }
    
}
