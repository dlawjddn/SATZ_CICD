package com.example.stazcicd.service;

import com.example.stazcicd.domain.User;
import com.example.stazcicd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public void saveUser() {
        /**
         * 자 생각해보면, dev에서 작업을 하고, prod에서 배포 중이라면
         * 개발을 진행하면 dev가 커밋이 앞서고, 개발 완료한 사항들을 적용하기 위해서 prod에 pr을 생성해서 merge를 함
         * 이때, pr을 생성하고, merge를 하는 과정에서 merge에 대한 커밋이 발생함. 이는 dev와 prod가 절대 커밋 히스토리가 일치할 수 없음(계속된 merge는)
         *
         * 따라서 dev -> prod로 pr, merge를 진행하고, dev에서 prod를 풀 받으면
         *
         * 1. prod는 dev에 비해 앞선 커밋이 없어짐.
         * 2. dev도 prod와 동일한 버전(히스토리)을 갖게 됨
         */
        for (int i = 0; i < 100; i++) {
            userRepository.save(
                    User.builder()
                            .name("임정우" + String.valueOf(i))
                            .nickname("dlawjddn " + String.valueOf(i))
                            .build()
            );
        }
    }

    public List<String> getAllUsername() {
        return userRepository.findAllUsername();
    }

    public List<String> getAllUserNickname() {
        return userRepository.findAllUserNickname();
    }

}
