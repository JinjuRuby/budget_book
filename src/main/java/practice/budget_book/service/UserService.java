package practice.budget_book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.budget_book.dto.UserJoinRequest;
import practice.budget_book.entity.User;
import practice.budget_book.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(UserJoinRequest userJoinRequest) {

        if (userRepository.existsByEmail(userJoinRequest.getEmail())) {

            throw new RuntimeException("이미 존재하는 회원입니다.");

        }

        User user = User.builder()
                .email(userJoinRequest.getEmail())
                .password(userJoinRequest.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return savedUser.getId();

    }

}
