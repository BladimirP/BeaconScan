package cl.valdivia.uach.geosensores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.valdivia.uach.geosensores.dagger.BluetoothModule
import org.altbeacon.beacon.BeaconManager
import org.altbeacon.beacon.BeaconParser

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val instance = BeaconManager.getInstanceForApplication(this)

        // Sets the delay between each scans according to the settings
        //instance.foregroundBetweenScanPeriod = prefs.getScanDelay()

        // Add all the beacon types we want to discover
        instance.beaconParsers.add(BeaconParser().setBeaconLayout(BluetoothModule.IBEACON_LAYOUT))
        instance.beaconParsers.add(BeaconParser().setBeaconLayout(BluetoothModule.EDDYSTONE_UID_LAYOUT))
        instance.beaconParsers.add(BeaconParser().setBeaconLayout(BluetoothModule.EDDYSTONE_URL_LAYOUT))
        instance.beaconParsers.add(BeaconParser().setBeaconLayout(BluetoothModule.EDDYSTONE_TLM_LAYOUT))
    }

    companion object {
        const val EDDYSTONE_URL_LAYOUT = BeaconParser.EDDYSTONE_URL_LAYOUT
        const val RUUVI_LAYOUT = "m:0-2=0499,i:4-19,i:20-21,i:22-23,p:24-24" // TBD
        const val IBEACON_LAYOUT = "m:0-3=4c000215,i:4-19,i:20-21,i:22-23,p:24-24"
        const val ALTBEACON_LAYOUT = BeaconParser.ALTBEACON_LAYOUT
        const val EDDYSTONE_UID_LAYOUT = BeaconParser.EDDYSTONE_UID_LAYOUT
        const val EDDYSTONE_TLM_LAYOUT = BeaconParser.EDDYSTONE_TLM_LAYOUT
        val TAG = "MainActivity"
    }
}