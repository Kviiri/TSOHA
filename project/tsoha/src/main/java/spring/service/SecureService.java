package spring.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface SecureService {

    @PreAuthorize("hasRole('admin')")
    public void executeOnlyIfAuthenticatedAsAdmin();

    @PreAuthorize("isAuthenticated()")
    public void executeOnlyIfAuthenticated();

    public void executeFreely();
}
