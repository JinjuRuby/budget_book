package practice.budget_book.dto;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class UserJoinRequest {


    private String email;
    private String password;

}
