package org.lsi.services;

import java.util.List;

import org.lsi.entities.Complaint;

public interface ComplaintService {
    public void addComplaint(Complaint c);
    public List<Complaint> getAll();
}
