package com.example.core_network.babyInfo

import com.example.core_model.BabyInfo
import com.example.core_model.Resource
import com.example.core_network.api.NetworkApi
import com.example.core_network.model.BabyInfoItem
import kotlinx.coroutines.delay
import javax.inject.Inject

class BabyInfoDataSourceImp @Inject constructor(
    private val networkApi: NetworkApi
) : BabyInfoDataSource {

    override suspend fun fetchBabyInfo(): Resource<List<BabyInfoItem>> {
        //To simulate the call time
        delay(1000)
        return Resource.Success(
            getBabyInfoItemsFromMockedString()
        )
    }

    private fun getBabyInfoItemsFromMockedString(): List<BabyInfoItem> {
        val listOfBabyInfo = mutableListOf<BabyInfoItem>()
        val newString = data.removePrefix("[\n").removeSuffix("\n ]")
        val list = newString.split(",\n")
        list.forEach {
            val arrayOfItems = it.removeSuffix("\"]").removePrefix("     [\"").split("\", \"")
            val item = BabyInfoItem(
                arrayOfItems[0].toInt(),
                arrayOfItems[1],
                arrayOfItems[2],
                arrayOfItems[3],
                arrayOfItems[4].toInt(),
                arrayOfItems[5].toInt(),
            )
            listOfBabyInfo.add(item)
        }
        return listOfBabyInfo.toList()
    }

    val data = "[\n" +
            "     [\"2016\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Olivia\", \"172\", \"1\"],\n" +
            "     [\"2016\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Chloe\", \"112\", \"2\"],\n" +
            "     [\"2016\", \"FEMALE\", \"BLACK NON HISPANIC\", \"Ava\", \"109\", \"1\"],\n" +
            "     [\"2016\", \"FEMALE\", \"BLACK NON HISPANIC\", \"Madison\", \"104\", \"2\"],\n" +
            "     [\"2016\", \"FEMALE\", \"HISPANIC\", \"Isabella\", \"276\", \"1\"],\n" +
            "     [\"2016\", \"FEMALE\", \"HISPANIC\", \"Sophia\", \"261\", \"2\"],\n" +
            "     [\"2016\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Olivia\", \"230\", \"1\"],\n" +
            "     [\"2016\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Rachel\", \"221\", \"2\"],\n" +
            "     [\"2016\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Ethan\", \"193\", \"1\"],\n" +
            "     [\"2016\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Ryan\", \"160\", \"2\"],\n" +
            "     [\"2016\", \"MALE\", \"BLACK NON HISPANIC\", \"Noah\", \"148\", \"1\"],\n" +
            "     [\"2016\", \"MALE\", \"BLACK NON HISPANIC\", \"Aiden\", \"137\", \"2\"],\n" +
            "     [\"2016\", \"MALE\", \"HISPANIC\", \"Liam\", \"387\", \"1\"],\n" +
            "     [\"2016\", \"MALE\", \"HISPANIC\", \"Jacob\", \"351\", \"2\"],\n" +
            "     [\"2016\", \"MALE\", \"WHITE NON HISPANIC\", \"Joseph\", \"261\", \"1\"],\n" +
            "     [\"2016\", \"MALE\", \"WHITE NON HISPANIC\", \"Michael\", \"260\", \"2\"],\n" +
            "     [\"2015\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Olivia\", \"188\", \"1\"],\n" +
            "     [\"2015\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Chloe\", \"119\", \"2\"],\n" +
            "     [\"2015\", \"FEMALE\", \"BLACK NON HISPANIC\", \"Madison\", \"128\", \"1\"],\n" +
            "     [\"2015\", \"FEMALE\", \"BLACK NON HISPANIC\", \"Skylar\", \"91\", \"2\"],\n" +
            "     [\"2015\", \"FEMALE\", \"HISPANIC\", \"Isabella\", \"307\", \"1\"],\n" +
            "     [\"2015\", \"FEMALE\", \"HISPANIC\", \"Sophia\", \"269\", \"2\"],\n" +
            "     [\"2015\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Emma\", \"225\", \"1\"],\n" +
            "     [\"2015\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Olivia\", \"225\", \"1\"],\n" +
            "     [\"2015\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Leah\", \"220\", \"2\"],\n" +
            "     [\"2015\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Jayden\", \"190\", \"1\"],\n" +
            "     [\"2015\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Ethan\", \"172\", \"2\"],\n" +
            "     [\"2015\", \"MALE\", \"BLACK NON HISPANIC\", \"Noah\", \"163\", \"1\"],\n" +
            "     [\"2015\", \"MALE\", \"BLACK NON HISPANIC\", \"Liam\", \"129\", \"2\"],\n" +
            "     [\"2015\", \"MALE\", \"HISPANIC\", \"Liam\", \"356\", \"1\"],\n" +
            "     [\"2015\", \"MALE\", \"HISPANIC\", \"Dylan\", \"339\", \"2\"],\n" +
            "     [\"2015\", \"MALE\", \"WHITE NON HISPANIC\", \"David\", \"299\", \"1\"],\n" +
            "     [\"2015\", \"MALE\", \"WHITE NON HISPANIC\", \"Joseph\", \"279\", \"2\"],\n" +
            "     [\"2014\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Olivia\", \"141\", \"1\"],\n" +
            "     [\"2014\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Chloe\", \"111\", \"2\"],\n" +
            "     [\"2014\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Sophia\", \"111\", \"2\"],\n" +
            "     [\"2014\", \"FEMALE\", \"BLACK NON HISPANIC\", \"Madison\", \"130\", \"1\"],\n" +
            "     [\"2014\", \"FEMALE\", \"BLACK NON HISPANIC\", \"Ava\", \"78\", \"2\"],\n" +
            "     [\"2014\", \"FEMALE\", \"HISPANIC\", \"Isabella\", \"331\", \"1\"],\n" +
            "     [\"2014\", \"FEMALE\", \"HISPANIC\", \"Sophia\", \"259\", \"2\"],\n" +
            "     [\"2014\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Olivia\", \"248\", \"1\"],\n" +
            "     [\"2014\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Esther\", \"233\", \"2\"],\n" +
            "     [\"2014\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Jayden\", \"187\", \"1\"],\n" +
            "     [\"2014\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Ethan\", \"179\", \"2\"],\n" +
            "     [\"2014\", \"MALE\", \"BLACK NON HISPANIC\", \"Ethan\", \"138\", \"1\"],\n" +
            "     [\"2014\", \"MALE\", \"BLACK NON HISPANIC\", \"Noah\", \"128\", \"2\"],\n" +
            "     [\"2014\", \"MALE\", \"HISPANIC\", \"Liam\", \"312\", \"1\"],\n" +
            "     [\"2014\", \"MALE\", \"HISPANIC\", \"Dylan\", \"292\", \"2\"],\n" +
            "     [\"2014\", \"MALE\", \"HISPANIC\", \"Jacob\", \"292\", \"2\"],\n" +
            "     [\"2014\", \"MALE\", \"WHITE NON HISPANIC\", \"Joseph\", \"300\", \"1\"],\n" +
            "     [\"2014\", \"MALE\", \"WHITE NON HISPANIC\", \"David\", \"272\", \"2\"],\n" +
            "     [\"2013\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Sophia\", \"124\", \"1\"],\n" +
            "     [\"2013\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Chloe\", \"122\", \"2\"],\n" +
            "     [\"2013\", \"FEMALE\", \"BLACK NON HISPANIC\", \"Madison\", \"134\", \"1\"],\n" +
            "     [\"2013\", \"FEMALE\", \"BLACK NON HISPANIC\", \"London\", \"76\", \"2\"],\n" +
            "     [\"2013\", \"FEMALE\", \"HISPANIC\", \"Isabella\", \"326\", \"1\"],\n" +
            "     [\"2013\", \"FEMALE\", \"HISPANIC\", \"Sophia\", \"291\", \"2\"],\n" +
            "     [\"2013\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Olivia\", \"233\", \"1\"],\n" +
            "     [\"2013\", \"FEMALE\", \"WHITE NON HISPANIC\", \"Emma\", \"228\", \"2\"],\n" +
            "     [\"2013\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Jayden\", \"220\", \"1\"],\n" +
            "     [\"2013\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"Ethan\", \"165\", \"2\"],\n" +
            "     [\"2013\", \"MALE\", \"BLACK NON HISPANIC\", \"Ethan\", \"146\", \"1\"],\n" +
            "     [\"2013\", \"MALE\", \"BLACK NON HISPANIC\", \"Jayden\", \"138\", \"2\"],\n" +
            "     [\"2013\", \"MALE\", \"HISPANIC\", \"Jayden\", \"352\", \"1\"],\n" +
            "     [\"2013\", \"MALE\", \"HISPANIC\", \"Jacob\", \"297\", \"2\"],\n" +
            "     [\"2013\", \"MALE\", \"WHITE NON HISPANIC\", \"David\", \"304\", \"1\"],\n" +
            "     [\"2013\", \"MALE\", \"WHITE NON HISPANIC\", \"Joseph\", \"283\", \"2\"],\n" +
            "     [\"2012\", \"FEMALE\", \"ASIAN AND PACI\", \"CHLOE\", \"172\", \"1\"],\n" +
            "     [\"2012\", \"FEMALE\", \"ASIAN AND PACI\", \"SOPHIA\", \"144\", \"2\"],\n" +
            "     [\"2012\", \"FEMALE\", \"BLACK NON HISP\", \"MADISON\", \"159\", \"1\"],\n" +
            "     [\"2012\", \"FEMALE\", \"BLACK NON HISP\", \"LONDON\", \"87\", \"2\"],\n" +
            "     [\"2012\", \"FEMALE\", \"HISPANIC\", \"ISABELLA\", \"327\", \"1\"],\n" +
            "     [\"2012\", \"FEMALE\", \"HISPANIC\", \"SOPHIA\", \"236\", \"2\"],\n" +
            "     [\"2012\", \"FEMALE\", \"WHITE NON HISP\", \"EMMA\", \"228\", \"1\"],\n" +
            "     [\"2012\", \"FEMALE\", \"WHITE NON HISP\", \"LEAH\", \"219\", \"2\"],\n" +
            "     [\"2012\", \"MALE\", \"ASIAN AND PACI\", \"RYAN\", \"197\", \"1\"],\n" +
            "     [\"2012\", \"MALE\", \"ASIAN AND PACI\", \"JAYDEN\", \"187\", \"2\"],\n" +
            "     [\"2012\", \"MALE\", \"ASIAN AND PACI\", \"ETHAN\", \"187\", \"2\"],\n" +
            "     [\"2012\", \"MALE\", \"BLACK NON HISP\", \"JAYDEN\", \"171\", \"1\"],\n" +
            "     [\"2012\", \"MALE\", \"BLACK NON HISP\", \"AIDEN\", \"156\", \"2\"],\n" +
            "     [\"2012\", \"MALE\", \"HISPANIC\", \"JAYDEN\", \"364\", \"1\"],\n" +
            "     [\"2012\", \"MALE\", \"HISPANIC\", \"JACOB\", \"293\", \"2\"],\n" +
            "     [\"2012\", \"MALE\", \"WHITE NON HISP\", \"JOSEPH\", \"300\", \"1\"],\n" +
            "     [\"2012\", \"MALE\", \"WHITE NON HISP\", \"DAVID\", \"289\", \"2\"],\n" +
            "     [\"2011\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"SOPHIA\", \"119\", \"1\"],\n" +
            "     [\"2011\", \"FEMALE\", \"ASIAN AND PACIFIC ISLANDER\", \"CHLOE\", \"106\", \"2\"],\n" +
            "     [\"2011\", \"FEMALE\", \"BLACK NON HISPANIC\", \"MADISON\", \"176\", \"1\"],\n" +
            "     [\"2011\", \"FEMALE\", \"BLACK NON HISPANIC\", \"LONDON\", \"92\", \"2\"],\n" +
            "     [\"2011\", \"FEMALE\", \"HISPANIC\", \"ISABELLA\", \"331\", \"1\"],\n" +
            "     [\"2011\", \"FEMALE\", \"HISPANIC\", \"MIA\", \"229\", \"2\"],\n" +
            "     [\"2011\", \"FEMALE\", \"WHITE NON HISPANIC\", \"ESTHER\", \"224\", \"1\"],\n" +
            "     [\"2011\", \"FEMALE\", \"WHITE NON HISPANIC\", \"OLIVIA\", \"213\", \"2\"],\n" +
            "     [\"2011\", \"FEMALE\", \"WHITE NON HISPANIC\", \"EMMA\", \"213\", \"2\"],\n" +
            "     [\"2011\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"ETHAN\", \"177\", \"1\"],\n" +
            "     [\"2011\", \"MALE\", \"ASIAN AND PACIFIC ISLANDER\", \"JAYDEN\", \"173\", \"2\"],\n" +
            "     [\"2011\", \"MALE\", \"BLACK NON HISPANIC\", \"JAYDEN\", \"184\", \"1\"],\n" +
            "     [\"2011\", \"MALE\", \"BLACK NON HISPANIC\", \"AIDEN\", \"167\", \"2\"],\n" +
            "     [\"2011\", \"MALE\", \"HISPANIC\", \"JAYDEN\", \"426\", \"1\"],\n" +
            "     [\"2011\", \"MALE\", \"HISPANIC\", \"JUSTIN\", \"310\", \"2\"],\n" +
            "     [\"2011\", \"MALE\", \"WHITE NON HISPANIC\", \"MICHAEL\", \"292\", \"1\"],\n" +
            "     [\"2011\", \"MALE\", \"WHITE NON HISPANIC\", \"JOSEPH\", \"281\", \"2\"]\n" +
            " ]"

}