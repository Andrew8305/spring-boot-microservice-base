package jp.drjoy.service.mobile.api.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.drjoy.service.mobile.model.SampleItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// TODO 削除
@Service
public class SampleService {

    private Logger logger = LoggerFactory.getLogger(SampleService.class);

    private static Map<String, SampleItem> items = new HashMap<>();

    public void register(SampleItem item) {
        logger.info("received SampleItem. {}", item.toString());

        items.put(item.getId(), item);
    }

    public List<SampleItem> all() {
        List<SampleItem> accounts = new ArrayList<>(SampleService.items.values());
        accounts.sort(Comparator.comparing(SampleItem::getId));
        return accounts;
    }

    public void modify(SampleItem item) {
        if (!items.containsKey(item.getId())) {
            throw new IllegalStateException("Specified item does not exits. id:" + item.getId());
        }

        SampleItem before = items.get(item.getId());
        logger.info("modify item. before:{}, after:{}", before, item);
        items.put(item.getId(), item);
    }

    public SampleItem findById(String id) {
        if (!items.containsKey(id)) {
            throw new IllegalStateException("Specified item does not exits. id:" + id);
        }

        return items.get(id);
    }

    public void delete(String id) {
        if (!items.containsKey(id)) {
            throw new IllegalStateException("Specified item does not exits. id:" + id);
        }

        items.remove(id);
    }
}