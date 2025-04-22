package study.study.study.member.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.study.study.common.dto.BaseResponse
import study.study.study.member.dto.MemberDtoRequest
import study.study.study.member.service.MemberService

@RequestMapping("/api/member")
@RestController
class MemberController (
    private val memberService: MemberService
){
    /*
    * 회원가입
    * */
    @PostMapping("/signup")
    fun sigUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMsg: String = memberService.singUp(memberDtoRequest)
        return BaseResponse(message = resultMsg)
    }
}