package com.admitone.services;

import com.admitone.dao.ShowDAO;
import com.admitone.model.Shows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by j_elbatn on 1/22/17.
 */

@Service
public class ShowService {

    @Autowired
    ShowDAO showDAO;

    public List<Long> getEventsByIdRange(long fromShowId, long toShowId) throws Exception {
        List<Shows> shows = new ArrayList<Shows>();

        try {
            shows = showDAO.getShowsByIdRange(fromShowId, toShowId);
        } catch (Exception e) {
            throw new Exception(e);
        }

        return shows.stream().map(Shows::getShowId).collect(Collectors.toList());

    }
}
