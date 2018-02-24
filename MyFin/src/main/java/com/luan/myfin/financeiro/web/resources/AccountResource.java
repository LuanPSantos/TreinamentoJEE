package com.luan.myfin.financeiro.web.resources;

import com.luan.myfin.financeiro.base.interfaces.AccountService;
import com.luan.myfin.financeiro.base.models.Account;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("account")
public class AccountResource {

    @EJB
    private AccountService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectCurrentAccount() {
        Account account = service.selectCurrentAccount();

        if (account != null) {
            return Response.ok(account).build();
        } else {
            return Response.noContent().build();
        }
    }
}
