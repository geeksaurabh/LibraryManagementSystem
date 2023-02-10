package com.saurabh.LibraryManagementSystem.service;

import com.saurabh.LibraryManagementSystem.model.LMS;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LMSService {
    private static List<LMS> libraries = new ArrayList<>();
    static int autoNum = 0;
    static{
        libraries.add(new LMS("ShivChatrapati Govt library", "ShivajiNagar, Pune", ++autoNum, 45));
        libraries.add(new LMS("Nagpur Public library", "Sambhaji Nagar, Nagpur", ++autoNum, 25));
        libraries.add(new LMS("Babasaheb Ambedkar Granthalay", "Bhimakoregaon, Mumbai", ++autoNum, 47));
        libraries.add(new LMS("Shahu Maharaj Yuva Kalyan Grathalay", "Mahad, Raigad", ++autoNum, 53));
        libraries.add(new LMS("Sir APJ Abdul kalam Govt library", "Jidga, Aland", ++autoNum, 65));
    }

    public List<LMS> getAllLibraries() {
        return libraries;
    }

    public LMS getLibrary(String name) {
        for (LMS library: libraries){
            if(library.getName().equals(name)) return library;
        }
        return null;
    }

    public String addLibrary(LMS library) {
        libraries.add(new LMS(library.getName(),
                library.getAddress(),
                ++autoNum,
                library.getFaculties()));
        return library.getName() + " Added Successfully!";
    }

    public String updateLibrary(LMS library, String name) {
        LMS oldLibrary = this.getLibrary(name);
        if(oldLibrary != null) {
            if (library.getName() != null) oldLibrary.setName(library.getName());
            if (library.getFaculties() != 0) oldLibrary.setFaculties(library.getFaculties());
            if (library.getAddress() != null) oldLibrary.setAddress(library.getAddress());
            if (library.getNumber() != 0) oldLibrary.setNumber(library.getNumber());
            return "Library with name " + name + " Updated Successfully";
        }
        else return "Library not found to Update, Add library first";
    }

    public String deleteLibrary(String name) {
        LMS library = this.getLibrary(name);
        if(library != null) {
            libraries.remove(library.getNumber()-1);
            return "Library with name " + name + " Deleted Successfully";
        }
        else return "Library not found to Delete, Add library first";
    }
}
