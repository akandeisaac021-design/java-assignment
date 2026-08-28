package africa.semicolon.noStrings.services;

import africa.semicolon.noStrings.dtos.requests.RegisterUserRequest;
import africa.semicolon.noStrings.dtos.responses.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse register(RegisterUserRequest request);
}
