package org.sopt.cdsserver.member.service;


import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.common.exception.enums.ErrorType;
import org.sopt.cdsserver.common.exception.model.NotFoundException;
import org.sopt.cdsserver.member.domain.Member;
import org.sopt.cdsserver.member.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;

    public Member getMemberById(final Long memberId) {
        return memberJpaRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorType.MEMBER_NOT_FOUND_EXCEPTION));
    }
}
