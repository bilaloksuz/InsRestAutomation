import com.Common.Base.Config;
import com.Pet.Request.CreatePet;
import com.Pet.Request.UpdatePet;
import com.Pet.Request.UriForApis;
import org.junit.Assert;
import kong.unirest.HttpResponse;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

public class RunTest {


    public static void main(String[] args)
    {
        Config config = new Config().config("production");
        int id = (int)(Math.random()*(400-40+1)+40);
        String name = RandomStringUtils.random(10, true, false);

        CreatePet createPet = new CreatePet();
        UriForApis getApis = new UriForApis();
        UpdatePet updatePet = new UpdatePet();

        HttpResponse<String> createResponse = createPet.sendRequest(id, name);
        Assert.assertTrue(config.getValidationMessagePositive()+createResponse.getStatus()+" in create api",createResponse.isSuccess());
        Assert.assertNotEquals(config.getResponseCodePositive(),null,createResponse.getBody());

        HttpResponse<String> createResponseWhenNameNull = createPet.sendRequest(id, null);
        Assert.assertTrue(config.getValidationMessageNegative()+" "+createResponseWhenNameNull.getStatus()+" in create api",!createResponseWhenNameNull.isSuccess());
        Assert.assertEquals(config.getResponseCodeNegative(),null,createResponseWhenNameNull.getBody());

        HttpResponse<String> createResponseWhenIdZero = createPet.sendRequest(0, name);
        Assert.assertTrue(config.getValidationMessageNegative()+" "+createResponseWhenIdZero.getStatus()+" in create api",!createResponseWhenIdZero.isSuccess());
        Assert.assertEquals(config.getResponseCodeNegative(),null,createResponseWhenIdZero.getBody());

        HttpResponse<String> updateResponse = updatePet.sendRequest(id, name);
        Assert.assertTrue(config.getValidationMessagePositive()+updateResponse.getStatus()+" in create api",updateResponse.isSuccess());
        Assert.assertNotEquals(config.getResponseCodePositive(),null,updateResponse.getBody());

        HttpResponse<String> updateResponseWhenNameNull = updatePet.sendRequest(id, null);
        Assert.assertTrue(config.getValidationMessageNegative()+updateResponseWhenNameNull.getStatus()+" in create api",!updateResponseWhenNameNull.isSuccess());
        Assert.assertNotEquals(config.getResponseCodeNegative(),null,updateResponseWhenNameNull.getBody());

        HttpResponse<String> updateResponseWhenIdZero = updatePet.sendRequest(0, name);
        Assert.assertTrue(config.getValidationMessageNegative()+updateResponseWhenIdZero.getStatus()+" in create api",!updateResponseWhenIdZero.isSuccess());
        Assert.assertNotEquals(config.getResponseCodeNegative(),null,updateResponseWhenIdZero.getBody());

        HttpResponse<String> getByIdResponse=getApis.findById(id);
        Assert.assertTrue(config.getValidationMessagePositive()+" "+getByIdResponse.getStatus()+" in getById api",getByIdResponse.isSuccess());
        Assert.assertNotEquals(config.getResponseCodePositive(),null,getByIdResponse.getBody());

        HttpResponse<String> getByIdResponseWhenIdZero=getApis.findById(0);
        Assert.assertTrue(config.getValidationMessageNegative()+" "+getByIdResponseWhenIdZero.getStatus()+" in getById api",!getByIdResponseWhenIdZero.isSuccess());
        Assert.assertNotEquals(config.getValidationMessageNegative(),null,getByIdResponseWhenIdZero.getBody());

        HttpResponse<String> getByStatus=getApis.findByStatus("available");
        Assert.assertTrue(config.getValidationMessagePositive()+" "+getByStatus.getStatus()+" in getByStatus api",getByStatus.isSuccess());
        Assert.assertNotEquals(config.getResponseCodePositive(),null,getByStatus.getBody());

        HttpResponse<String> getByStatusWhenStatusNotExits=getApis.findByStatus("available1");
        Assert.assertTrue(config.getValidationMessageNegative()+" "+getByStatusWhenStatusNotExits.getStatus()+" in getByStatus api",!getByStatusWhenStatusNotExits.isSuccess());
        Assert.assertNotEquals(config.getResponseCodeNegative(),null,getByStatusWhenStatusNotExits.getBody());

        HttpResponse<String> deleteById=getApis.deleteById(id);
        Assert.assertTrue(config.getValidationMessagePositive()+" "+deleteById.getStatus()+" in delete api",deleteById.isSuccess());
        Assert.assertNotEquals(config.getResponseCodePositive(),null,deleteById.getBody());

        HttpResponse<String> deleteByIdWhenIdZero=getApis.deleteById(0);
        Assert.assertTrue(config.getValidationMessageNegative()+" "+deleteByIdWhenIdZero.getStatus()+" in delete api",!deleteByIdWhenIdZero.isSuccess());
        Assert.assertNotEquals(config.getResponseCodeNegative(),null,deleteByIdWhenIdZero.getBody());

    }
}
