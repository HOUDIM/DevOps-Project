package com.houssem.Dimassi_Informatique.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.houssem.Dimassi_Informatique.entities.Photos;

public interface IServicePhotos {
	void savePhotos(Photos photo, MultipartFile mainPhoto,MultipartFile[] extraImages) throws IOException;
    Photos getPhoto(int id);
    Photos getPhotosByProduit(Integer id);
    void deletePhoto(Integer id) throws IOException;
    String saveImage(MultipartFile mf)throws IOException ;
    public byte[] getPhotos(int id) throws IOException;
    public byte[] getPhotos2(int id) throws IOException;
    public byte[] getPhotos3(int id) throws IOException;
    public byte[] getPhotos4(int id) throws IOException;
}
