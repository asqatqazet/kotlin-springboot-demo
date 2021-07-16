package demo.data

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@EntityScan
@Table("MESSAGES")
data class Message(@Id val id:String?, val text: String)