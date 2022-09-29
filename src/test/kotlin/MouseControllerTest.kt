import d2r.MouseController
import external.nuttree.Region
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.test.Test

@DelicateCoroutinesApi
class MouseControllerTest {
  @Test
  fun clickOnRegionCenterTest() {
    GlobalScope.launch {
      MouseController.clickOnRegionCenter(Region(left = 0, top = 0, width = 1200, height = 1200))
    }
  }
}
