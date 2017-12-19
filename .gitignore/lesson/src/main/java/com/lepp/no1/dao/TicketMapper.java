package com.lepp.no1.dao;


import com.lepp.no1.model.Ticket;

public interface TicketMapper {
    int deleteByPrimaryKey(String id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}