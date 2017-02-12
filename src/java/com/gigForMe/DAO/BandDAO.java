/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;

import com.gigForMe.model.Band;
import java.util.ArrayList;

/**

 * @author anthonyhayes
 */
public interface BandDAO {
   public ArrayList<Band> getAllBands();
   public Band getBand(int bandID);
   public void insertBand(Band band);
   public void updateBand(Band band);
   public void deleteBand(int bandID);
}
