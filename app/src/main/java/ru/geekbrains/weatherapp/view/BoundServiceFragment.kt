package ru.geekbrains.weatherapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.ComponentName
import android.os.IBinder
import android.content.ServiceConnection
import android.content.Context.BIND_AUTO_CREATE
import ru.geekbrains.weatherapp.BoundService
import android.content.Intent
import android.widget.Button
import ru.geekbrains.weatherapp.R


private const val ARG_PARAM1 = "param1"

class BoundServiceFragment : Fragment() {

    private var buttonBindService: Button? = null
    private var buttonNextFibo: Button? = null
    private var textFibonacci: TextView? = null
    private var isBound = false
    private var boundService: BoundService.ServiceBinder? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_bound_service, container, false)
        initView(layout)
        return layout;
    }

    private fun initView(v: View) {
        textFibonacci = v.findViewById(R.id.textFibonacci)

        buttonBindService = v.findViewById(R.id.buttonBindService)
        buttonBindService?.setOnClickListener {
            val intent = Intent(activity, BoundService::class.java)
            activity?.bindService(intent, boundServiceConnection, BIND_AUTO_CREATE)
        }

        buttonNextFibo = v.findViewById(R.id.buttonNextFibo)
        buttonNextFibo?.setOnClickListener {
            if (boundService == null) {
                textFibonacci?.text = "Unbound service"
            } else {
                val fibo = boundService?.getNextFibonacci()
                textFibonacci?.text = fibo.toString()
            }
        }
    }

    // Обработка соединения с сервисом
    private val boundServiceConnection: ServiceConnection = object : ServiceConnection {
        // При соединении с сервисом
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            boundService = service as BoundService.ServiceBinder
            isBound = boundService != null
        }

        // При разрыве соединения с сервисом
        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
            boundService = null
        }
    }

    companion object {
        fun newInstance() = BoundServiceFragment()
    }
}