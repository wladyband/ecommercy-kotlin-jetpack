package com.bandeira.ecommerceappmvvm.domain.util


import com.bandeira.ecommerceappmvvm.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result: Response<T>): Resource<T> {
        return try {
                    if (result.isSuccessful) { // 201
                Resource.Success(result.body()!!)
            }
            else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconhecido")
            }
        }
        catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconhecido da requisição Http")
        }
        catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verificar a conexão com internet")
        }
        catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconhecido")
        }
    }

}