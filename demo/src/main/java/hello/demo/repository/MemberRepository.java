package hello.demo.repository;

import hello.demo.domain.Member;

import java.util.List;
import java.util.Optional;

// member repository의 인터페이스 작성
public interface MemberRepository {
    // 회원 저장
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
