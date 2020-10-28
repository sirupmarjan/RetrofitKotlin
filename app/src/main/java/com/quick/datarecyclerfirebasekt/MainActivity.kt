package com.quick.datarecyclerfirebasekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.quick.datarecyclerfirebasekt.Adapter.UsersAdapter
import com.quick.datarecyclerfirebasekt.Model.Users
import com.quick.datarecyclerfirebasekt.Retrofit.NetworkConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        NetworkConfig().getService()
            .getUser()
            .enqueue(object : Callback<List<Users>> {
                override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<Users>>,
                    response: Response<List<Users>>)
                {
                    rv_user.layoutManager = LinearLayoutManager(this@MainActivity)
                    rv_user.adapter = UsersAdapter(response.body())
                }

            })

    }
}