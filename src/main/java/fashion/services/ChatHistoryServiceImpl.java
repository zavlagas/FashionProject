/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.services;

import java.util.List;
import java.util.Map;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ChatHistoryServiceImpl implements ChatHistoryService {

    private final Cache<UUID, Map<String, String>> chatHistoryCache = CacheBuilder
            .newBuilder().maximumSize(20).expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    @Override
    public void save(Map<String, String> message) {
        this.chatHistoryCache.put(UUID.randomUUID(), message);
    }

    @Override
    public List<Map<String, String>> get() {
        return chatHistoryCache.asMap().values().stream()
                .sorted((c1, c2) -> Long.valueOf(c1.get("timestamp"))
                .compareTo(Long.valueOf(c2.get("timestamp"))))
                .collect(Collectors.toList());
    }

}
