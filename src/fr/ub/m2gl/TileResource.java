package fr.ub.m2gl;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("")
public class TileResource {
	
	@GET
	@Path("/{z}/{x}/{y}")
    @Produces("image/png")
    public Response delUser(@PathParam("z") int z, @PathParam("x") int x, @PathParam("y") int y) throws IOException {
		byte[] res;
		HBaseLink.HBaseProg hb = new HBaseLink.HBaseProg();
		res = hb.get(z, x, y);
		return Response.ok(res).build();
    }
}
