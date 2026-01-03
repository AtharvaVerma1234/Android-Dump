package com.droiduino.bluetoothconn

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar

class SelectDeviceActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_device)

        // Bluetooth Setup
        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

        // Get List of Paired Bluetooth Device
        val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter?.bondedDevices
        val deviceList = ArrayList<Any>()

        if (!pairedDevices.isNullOrEmpty()) {
            // There are paired devices. Get the name and address of each paired device.
            for (device: BluetoothDevice in pairedDevices) {
                val deviceName: String = device.name
                val deviceHardwareAddress: String = device.address // MAC address
                val deviceInfoModel = DeviceInfoModel(deviceName, deviceHardwareAddress)
                deviceList.add(deviceInfoModel)
            }
            // Display paired devices using recyclerView
            val recyclerView: RecyclerView = findViewById(R.id.recyclerViewDevice)
            recyclerView.layoutManager = LinearLayoutManager(this)
            val deviceListAdapter = DeviceListAdapter(this, deviceList)
            recyclerView.adapter = deviceListAdapter
            recyclerView.itemAnimator = DefaultItemAnimator()
        } else {
            val view: View = findViewById(R.id.recyclerViewDevice)
            val snackbar = Snackbar.make(view, "Activate Bluetooth or pair a Bluetooth device", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("OK") { }
            snackbar.show()
        }
    }
}
