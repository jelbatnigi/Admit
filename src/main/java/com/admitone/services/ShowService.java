package com.admitone.services;

import com.admitone.dao.ShowDAO;
import com.admitone.model.Shows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by j_elbatn on 1/22/17.
 */

@Service
public class ShowService {

    @Autowired
    ShowDAO showDAO;

    public List<Long> getEventsByIdRange(long fromShowId, long toShowId)
    {
        List<Shows> shows = showDAO.getShowsByIdRange(fromShowId, toShowId);

        return shows.stream().map(Shows::getShowId).collect(Collectors.toList());

    }
}
