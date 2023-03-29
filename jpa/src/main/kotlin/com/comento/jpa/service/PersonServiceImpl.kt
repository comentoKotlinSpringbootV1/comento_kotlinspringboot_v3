package com.comento.jpa.service

import com.comento.jpa.domain.company.CompanyRepository
import com.comento.jpa.domain.country.CountryRepository
import com.comento.jpa.domain.person.PersonRepository
import com.comento.jpa.dto.PersonDto
import com.comento.jpa.dto.PersonResultDto
import com.comento.jpa.enums.PersonResultType
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PersonServiceImpl(
    private val personRepository: PersonRepository,
    private val companyRepository: CompanyRepository,
    private val countryRepository: CountryRepository,
) : PersonService {

    @Transactional(rollbackOn = [Exception::class])
    override fun createOrChangePersons(personList: List<PersonDto>): PersonResultDto {
        val resultTypes = mutableListOf<PersonResultType>()
        val personIds = mutableListOf<Int>()

        personList.forEach { dto ->
            val country = countryRepository.findCountryByName(dto.country.uppercase())
                ?: throw IllegalArgumentException("유효하지 않은 나라명입니다:: ${dto.country}")
            val company = dto.company?.let {
                companyRepository.findByName(it) ?: throw IllegalArgumentException("유효하지 않은 회사명입니다:: $it")
            }

            val person = personRepository.findById(dto.personId).orElse(null)

            personRepository.save(dto.toEntity(country, company))

            if (person != null) {
                // Person이 이미 존재하면 업데이트
                resultTypes.add(PersonResultType.UPDATED)
            } else {
                // Person이 존재하지 않으면 새로 생성
                resultTypes.add(PersonResultType.ADDED)
            }

            personIds.add(dto.personId)
        }

        return PersonResultDto(resultTypes, personIds)
    }

}
