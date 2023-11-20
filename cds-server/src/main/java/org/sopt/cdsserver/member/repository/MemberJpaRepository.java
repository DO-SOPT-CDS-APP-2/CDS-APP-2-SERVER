package org.sopt.cdsserver.member.repository;

import org.sopt.cdsserver.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
