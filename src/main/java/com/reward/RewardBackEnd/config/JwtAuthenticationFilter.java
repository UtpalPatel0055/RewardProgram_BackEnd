package com.reward.RewardBackEnd.config;

public class JwtAuthenticationFilter
        //extends OncePerRequestFilter
{
//    private final JwtService jwtService;
//
//    private final UserServiceImpl userServiceImpl;
//
//    public JwtAuthenticationFilter(JwtService jwtService, UserServiceImpl userServiceImpl) {
//        this.jwtService = jwtService;
//        this.userServiceImpl = userServiceImpl;
//    }
//
//    @Override
//    protected void doFilterInternal(@NotNull HttpServletRequest request,
//                                    @NotNull HttpServletResponse response,
//                                    @NotNull FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Authorization");
//
//        if(authHeader == null || !authHeader.startsWith("Bearer")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = authHeader.substring(7);
//        String username = jwtService.extractUsername(token);
//
//        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userServiceImpl.loadUserByUsername(username);
//            if(jwtService.isValid(token, userDetails)) {
//                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities()
//                );
//                authToken.setDetails(
//                        new WebAuthenticationDetailsSource().buildDetails(request)
//                );
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
}