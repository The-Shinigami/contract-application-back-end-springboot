package org.lsi.services;

import java.util.List;
import java.util.Optional;

import org.lsi.entities.Proprety;

public interface PropretyService {
	public void addProprety(Proprety p);
	public Proprety updateProprety(String id,Proprety p);
    public List<Proprety> getAll();
	public Optional<Proprety> getById(String id);
	public List<Proprety> getByUserId(String id);

}
