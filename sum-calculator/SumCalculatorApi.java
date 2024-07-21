import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sum")
public class SumCalculatorApi {
    @GET
    @Path("/{n}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateSum(@PathParam("n") int n) {
        int result = SumCalculator.calculateSum(n);
        return String.valueOf(result);
    }
}