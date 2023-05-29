//package safraexpress.safraexpress.service;
//
//public class LocalizacaoService {
//    public LatLng getCoordinatesFromAddress(String address) throws ApiException, InterruptedException, IOException {
//        GeocodingResult[] results = GeocodingApi.geocode("YOUR_API_KEY", address).await();
//        if (results.length > 0) {
//            return results[0].geometry.location;
//        }
//        return null;
//    }
//
//    public double calculateDistance(LatLng point1, LatLng point2) {
//        double lat1 = point1.lat;
//        double lon1 = point1.lng;
//        double lat2 = point2.lat;
//        double lon2 = point2.lng;
//
//        double theta = lon1 - lon2;
//        double distance = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
//                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
//        distance = Math.acos(distance);
//        distance = Math.toDegrees(distance);
//        distance = distance * 60 * 1.1515;
//        return distance;
//    }
//}