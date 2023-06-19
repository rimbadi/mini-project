package id.co.indivara.jdt12.mpcarrent.services;

import id.co.indivara.jdt12.mpcarrent.models.Rent;

public interface RentService {
    //POST ("/rent")
    Rent rentACar(Rent rent);
}
