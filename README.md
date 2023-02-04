# Test detayı
1- Testler POST(Create), PUT(Update), Get(ById), Get(ByStatus), Delete(ById) servisleri için yazılmıştır.
2- Testlerde petId olan id ve petName olan name alanı için zorunluluk var olduğu varsayılarak pozitif ve negatif senaryolar çıkarılımştır.
3- Get,Delete,Put servislerinde, id bulunamadı senaryosu eklenmedi çünkü id=0 senaryosu hem 0 id olamaz validasyonu hem de id bulunamadı hatasını karşılamaktadır.

# Dosya içeriği
1- Http istekler unirest ile gönderilmektedir.
2- Testler tek main method altında topluca tetiklenebilmektedir.
3- Eğer herhangi bir test hata alırsa, test durmaktadır.

# Test detail
1- The test are written for PUT(Update), Get(ById), Get(ByStatus), Delete(ById) services.
2- In the tests, positive and negative scenarios were created, assuming that there is a necessity for the petId field id and petName name field.
3- In Get,Delete,Put services, id not found cases is not added because id=0 scenarios can be fulfills both of them.


# File content
1- Http requests are send with unirest.
2- Tests can be affected collectively under a single main method.
3- If any test is a fail, the test stops.
