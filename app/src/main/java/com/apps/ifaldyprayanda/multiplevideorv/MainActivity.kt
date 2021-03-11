package com.apps.ifaldyprayanda.multiplevideorv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import edmt.dev.videoplayer.adapter.VideoPlayerRecyclerAdapter
import edmt.dev.videoplayer.model.MediaObject
import edmt.dev.videoplayer.utils.VerticalSpacingItemDecorator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init video
        initVideos()
    }

    private fun initVideos() {
        val layoutManager = LinearLayoutManager(this)
        video_player.layoutManager = layoutManager

        // Vertical height
        val verticalItemDecor = VerticalSpacingItemDecorator(10)
        video_player.addItemDecoration(verticalItemDecor)

        //Init Source Video
        val sourceVideos : ArrayList<MediaObject> = ArrayList(sampleVideoList())
        video_player.setMediaObjects(sourceVideos)

        val adapter = VideoPlayerRecyclerAdapter(sourceVideos, initGlide())
        video_player.adapter = adapter
    }



    private fun sampleVideoList(): List<MediaObject> {
        return listOf(
            MediaObject("Big Buck Bunny",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                "https://i.ytimg.com/vi/aqz-KE-bpKQ/maxresdefault.jpg",
                ""),
            MediaObject("Elephant Dream",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                "https://piratskatelevize.cz/shows/Movies/elephants-dream.jpg",
                ""),
            MediaObject("For Bigger Blazes",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                "https://d2z1w4aiblvrwu.cloudfront.net/ad/76Ab/google-chromecast-bigger-blazes-large-7.jpg",
                ""),
            MediaObject("Subaru Outback On Street And Dirt",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
                "https://i.ytimg.com/vi/KyQAub_iLP4/maxresdefault.jpg",
                ""),
            MediaObject("Tears of Steel",
                "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
                "https://i.ytimg.com/vi/41hv2tW5Lc4/maxresdefault.jpg",
                "")
            )
    }

    private fun initGlide(): RequestManager? {
        val options = RequestOptions()
            .placeholder(R.drawable.white_background)
            .error(R.drawable.white_background)

        return Glide.with(this).setDefaultRequestOptions(options)
    }

}