package com.rifat.submission2kotlin.ui.detailMatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rifat.submission2kotlin.R
import com.rifat.submission2kotlin.model.Match
import kotlinx.android.synthetic.main.activity_detail_match.*
import java.lang.StringBuilder


class DetailMatchActivity : AppCompatActivity(),DetailMatchView {
    private var imgHome = ""
    private var imgAway = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        val bundle = intent.getBundleExtra("EXTRA_DATA")

        if (bundle != null){
            val match = bundle.getString("id").toString()
             imgHome = bundle.getString("imgHome").toString()
             imgAway = bundle.getString("imgAway").toString()

            val presenter = DetailMatchPresenter(this)
            presenter.detailget(match)
        }
    }

    private fun makeString(raw: List<String>?):String{
        val result = StringBuilder()
         if (!raw.isNullOrEmpty()){
             for (i in raw){
                 val data = "$i\n"
                 result.append(data)
             }
             return result.toString().dropLast(1)
         }
         return ""
    }


    override fun ShowMatch(data: Match) {
        Glide.with(this).load(imgHome).into(image_home_detail)
        Glide.with(this).load(imgAway).into(image_away_detail)

        if (data.awayGoalDetail != null){
            text_scorehome.text = data.homeScore
            text_scoreaway.text = data.awayScore
        }

        text_teamhome_detail.text = data.homeTeam
        text_teamaway_detail.text = data.awayTeam

        text_goalhome_detail.text = makeString(data.homeGoalDetail?.split(";"))
        text_goalaway_detail.text = makeString(data.awayGoalDetail?.split(";"))

        text_redhome_detail.text = makeString(data.homeRedCard?.split(";"))
        text_redaway_detail.text = makeString(data.awayRedCard?.split(";"))

        text_yellowhome_detail.text = makeString(data.homeYellowCard?.split(";"))
        text_yellowaway_detail.text = makeString(data.awayYellowCard?.split(";"))

        val datetime = "${data.matchTime} ${data.matchDate}"
        text_datetime_detail.text = datetime
    }
}
