package study.study.study.member.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import study.study.study.common.exception.InvalidInputException
import study.study.study.common.status.ROLE
import study.study.study.member.dto.MemberDtoRequest
import study.study.study.member.repository.MemberRepository
import study.study.study.member.entity.Member
import study.study.study.member.entity.MemberRole
import study.study.study.member.repository.MemberRoleRepository


@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val membeerRoleRepository: MemberRoleRepository
) {
    /*
    *회원가입
    * */
    fun singUp(memberDtoRequest: MemberDtoRequest): String{
        //ID 중복 검사
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if(member != null){
           throw InvalidInputException("loginId", "이미 등록된 ID 입니다.")
        }

        member = memberDtoRequest.toEntity()
        memberRepository.save(member)

        val memberRole: MemberRole = MemberRole(null, ROLE.MEMBER, member)
        membeerRoleRepository.save(memberRole)

        return "회원가입 완료되었습니다."
    }
}