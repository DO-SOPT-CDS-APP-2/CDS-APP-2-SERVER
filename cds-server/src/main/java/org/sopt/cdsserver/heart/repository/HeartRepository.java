package org.sopt.cdsserver.heart.repository;

import org.sopt.cdsserver.heart.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByMemberIdAndProductId(Long memberId, Long ProductId);
}
